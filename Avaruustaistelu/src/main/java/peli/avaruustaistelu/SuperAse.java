
package peli.avaruustaistelu;


public class SuperAse {
    
    private boolean lataus;

    public SuperAse() {
        this.lataus = true;
    }   
        
    public void lataa() {
        this.lataus = true;
    }
    
    public boolean onkoAseLadattu(){
        return this.lataus;
    }

    public void ammu() {
        if (onkoAseLadattu()) {
            this.lataus = false;
        }
    }
    
}
