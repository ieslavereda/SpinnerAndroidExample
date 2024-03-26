package es.ieslavereda.myapplication;

public enum Sexo implements Listable{
    HOMBRE,MUJER;

    @Override
    public String getDescription() {
        return this.name();
    }

    @Override
    public int getDrawableSimbol() {
        return this.equals(HOMBRE)?R.drawable.s_mas:R.drawable.s_fem;
    }

    @Override
    public int getDrawableImage() {
        return this.equals(HOMBRE)?R.drawable.i_mas:R.drawable.i_fem;
    }
}
