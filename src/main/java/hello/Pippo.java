package hello;

public class Pippo {

    public static void main(String[] args) {
        ro.pippo.core.Pippo pippo = new ro.pippo.core.Pippo(new BasicApplication());
        pippo.getServer().getSettings().port(8080);
        pippo.start();
    }
}
