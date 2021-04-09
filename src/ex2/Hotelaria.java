package ex2;

public class Hotelaria {

    private String nomeHotel;

    public Hotelaria() {
    }

    public Hotelaria(String nomeHotel) {
        this.nomeHotel = nomeHotel;
    }

    public String getNomeHotel() {
        return nomeHotel;
    }

    public void setNomeHotel(String nomeHotel) {
        this.nomeHotel = nomeHotel;
    }

    @Override
    public String toString() {
        return "Nome do HOTEL" + nomeHotel;
    }

}
