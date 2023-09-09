package BusinessLogic.Entities;

public class AACordenadaUcraniana {
    private String aaIdTipoArsenal;
    private String aaIdCoordenadas;
    private String aaIdDias;
    private String aaIdHora;
    private String aaIdArsenal;




    public AACordenadaUcraniana(
                                String aaIdTipoArsenal, 
                                String aaIdCoordenadas, 
                                String aaIdDias,
                                String aaIdArsenal,
                                String aaIdHora) {
                                    
    
        this.aaIdTipoArsenal = aaIdTipoArsenal;
        this.aaIdCoordenadas = aaIdCoordenadas;
        this.aaIdDias = aaIdDias;
        this.aaIdHora = aaIdHora;
        this.aaIdArsenal = aaIdArsenal;}
  
    public String getAaIdArsenal() {
        return aaIdArsenal;
    }
    public void setAaIdArsenal(String aaIdArsenal) {
        this.aaIdArsenal = aaIdArsenal;
    }

    public String getAaIdTipoArsenal() {
        return aaIdTipoArsenal;
    }
    public void setAaIdTipoArsenal(String aaIdTipoArsenal) {
        this.aaIdTipoArsenal = aaIdTipoArsenal;
    }
    public String getAaIdCoordenadas() {
        return aaIdCoordenadas;
    }
    public void setAaIdCoordenadas(String aaIdCoordenadas) {
        this.aaIdCoordenadas = aaIdCoordenadas;
    }
    public String getAaIdDias() {
        return aaIdDias;
    }
    public void setAaIdDias(String aaIdDias) {
        this.aaIdDias = aaIdDias;
    }
    public String getAaIdHora() {
        return aaIdHora;
    }
    public void setAaIdHora(String aaIdHora) {
        this.aaIdHora = aaIdHora;
    }
}
