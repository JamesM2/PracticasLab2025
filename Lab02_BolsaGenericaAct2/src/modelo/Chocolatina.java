package modelo;

public class Chocolatina implements Comparable<Chocolatina> {
    private String marca;

    public Chocolatina(String marca) {
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Chocolatina that = (Chocolatina) obj;
        return this.marca.equals(that.marca);
    }

    @Override
    public int compareTo(Chocolatina o) {
        return this.marca.compareTo(o.marca);
    }

    @Override
    public String toString() {
        return marca;
    }
}
