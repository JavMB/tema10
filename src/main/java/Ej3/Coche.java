package Ej3;


/**
 * The type Coche.
 */
public abstract class Coche {
    private static final int INCREMENTO = 5;

    private final String matricula;
    private double velocidadActual;
    private Marcha marchaActual;
    private final double[] velocidadesMaximas;

    /**
     * The enum Marcha.
     */
    public enum Marcha {
        /**
         * Primera marcha.
         */
        PRIMERA,
        /**
         * Segunda marcha.
         */
        SEGUNDA,
        /**
         * Tercera marcha.
         */
        TERCERA,
        /**
         * Cuarta marcha.
         */
        CUARTA,
        /**
         * Quinta marcha.
         */
        QUINTA,
        /**
         * Sexta marcha.
         */
        SEXTA
    }


    /**
     * Instantiates a new Coche.
     *
     * @param matricula          the matricula
     * @param velocidadesMaximas the velocidades maximas
     */
    public Coche(String matricula, double[] velocidadesMaximas) {
        this.matricula = matricula;
        this.velocidadActual = 0;
        this.marchaActual = Marcha.PRIMERA;
        this.velocidadesMaximas = velocidadesMaximas;
    }

    /**
     * Gets velocidad actual.
     *
     * @return the velocidad actual
     */
    public double getVelocidadActual() {
        return velocidadActual;
    }

    /**
     * Sets velocidad actual.
     *
     * @param velocidadActual the velocidad actual
     */
    public void setVelocidadActual(double velocidadActual) {
        if (!(velocidadActual < 0) && (velocidadActual < 300)) {
            this.velocidadActual = velocidadActual;
        }

    }

    /**
     * Gets marcha actual.
     *
     * @return the marcha actual
     */
    public Marcha getMarchaActual() {
        return marchaActual;
    }

    /**
     * Sets marcha actual.
     *
     * @param marchaActual the marcha actual
     */
    public void setMarchaActual(Marcha marchaActual) {
        if (marchaActual != null) {
            this.marchaActual = marchaActual;
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Get velocidades maximas double [ ].
     *
     * @return the double [ ]
     */
    public double[] getVelocidadesMaximas() {
        return velocidadesMaximas;
    }

    /**
     * Acelerar.
     *
     * @param pressed the pressed
     */
    public void acelerar(boolean pressed) {
        velocidadActual += INCREMENTO;


    }

    /**
     * Frenar.
     *
     * @param pressed the pressed
     */
    public void frenar(boolean pressed) {
        if (pressed && velocidadActual > INCREMENTO) {
            setVelocidadActual(velocidadActual -= INCREMENTO);
        }
    }

    /**
     * Cambiar marcha.
     *
     * @param marcha the marcha
     */
    protected abstract void cambiarMarcha(Marcha marcha);


}
