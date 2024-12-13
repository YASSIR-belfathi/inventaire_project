package payload.request;

public class ReservationRequest {
    private Long volId;
    private Long passagerId;
    private int prixTotal;

    // Getters et Setters
    public Long getVolId() {
        return volId;
    }

    public void setVolId(Long volId) {
        this.volId = volId;
    }

    public Long getPassagerId() {
        return passagerId;
    }

    public void setPassagerId(Long passagerId) {
        this.passagerId = passagerId;
    }

    public int getPrixTotal() {
        return prixTotal;
    }

    public void setPrixTotal(int prixTotal) {
        this.prixTotal = prixTotal;
    }
}
