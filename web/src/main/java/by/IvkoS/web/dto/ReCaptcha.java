package by.IvkoS.web.dto;

public class ReCaptcha {

    private String privateKey;
    private boolean valid = false;

    public boolean checkAnswer(String remoteAddr, String challenge, String response){
        return true;
    }

}
