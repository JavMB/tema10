package Ej7.Partidos;

public enum Afluencia {
    BAJA(0.75f), MEDIA(1.0f), ALTA(1.3f);

    public final float factorPrecio;

    Afluencia(float factorPrecio) {
        this.factorPrecio = factorPrecio;
    }


}
