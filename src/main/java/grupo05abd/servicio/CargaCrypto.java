package grupo05abd.servicio;

import grupo05abd.modelo.CryptoHistoricalPrice;
import grupo05abd.modeloDAO.CryptoHistoricalPriceDAO;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class CargaCrypto {

    private static final String COIN_ID = "solana";  // Cambia según el símbolo
    private static final String VS_CURRENCY = "usd";

    public void cargarDatos(String coinId) {
        try {
            CryptoHistoricalPriceDAO dao = new CryptoHistoricalPriceDAO();

            // Obtener la última fecha cargada
            Date ultimaFechaCargada = dao.obtenerUltimaFechaCargada(coinId);
            long fromTimestamp;
            if (ultimaFechaCargada != null) {
                fromTimestamp = (ultimaFechaCargada.toLocalDate().plusDays(1).atStartOfDay().toEpochSecond(java.time.ZoneOffset.UTC));
            } else {
                // Si no hay datos, pedimos desde el inicio (ejemplo: 2020-03-01 para Solana)
                fromTimestamp = java.time.LocalDate.of(2020, 3, 1).atStartOfDay().toEpochSecond(java.time.ZoneOffset.UTC);
            }

            long toTimestamp = java.time.LocalDate.now().atStartOfDay().toEpochSecond(java.time.ZoneOffset.UTC);

            String urlStr = String.format("https://api.coingecko.com/api/v3/coins/%s/market_chart/range?vs_currency=%s&from=%d&to=%d",
                    coinId, VS_CURRENCY, fromTimestamp, toTimestamp);

            URL url = new URL(urlStr);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Accept", "application/json");

            int responseCode = con.getResponseCode();
            if (responseCode == 200) {
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                JSONObject jsonResponse = new JSONObject(response.toString());
                JSONArray pricesArray = jsonResponse.getJSONArray("prices");

                List<CryptoHistoricalPrice> nuevosPrecios = new ArrayList<>();
                for (int i = 0; i < pricesArray.length(); i++) {
                    JSONArray pricePoint = pricesArray.getJSONArray(i);
                    long timestampMs = pricePoint.getLong(0);
                    double price = pricePoint.getDouble(1);

                    java.util.Date date = new java.util.Date(timestampMs);
                    Date sqlDate = new Date(date.getTime());

                    nuevosPrecios.add(new CryptoHistoricalPrice(0, coinId, sqlDate, price));
                }

                // Insertar nuevos precios
                for (CryptoHistoricalPrice price : nuevosPrecios) {
                    dao.insertar(price);
                }

                System.out.println("Carga de datos completa para " + coinId);

            } else {
                System.out.println("Error en la API de CoinGecko. Código: " + responseCode);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

