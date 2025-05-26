package grupo05abd.modelo;

public class Status {

private int statusId;
    private String name;
    private String statusDescription; // Nullable

    public Status(int statusId, String name, String statusDescription) {
        this.statusId = statusId;
        this.name = name;
        this.statusDescription = statusDescription;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatusDescription() {
        return statusDescription;
    }

    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }

    

}
