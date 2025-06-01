package functions;

import entidades.Worm;

public class Specific {

    public void armazenar(Worm worm, int minerio){
        String mineriosS;
        boolean definido = false;
        switch (minerio) {
            case 5:
                mineriosS = "sprites/minerios/terra_1.png";
                break;
            case 4:
                mineriosS = "sprites/minerios/cobre_1.png";
              break;
            case 3:
                mineriosS = "sprites/minerios/ferro_1.png";
              break;
            case 2:
                mineriosS = "sprites/minerios/ouro_1.png";
              break;
            case 1:
                mineriosS = "sprites/minerios/diamante_1.png";
              break;
            case 0:
                mineriosS = "sprites/minerios/rubi_1.png";
              break;
            default:
                mineriosS = "sprites/minerios/nada_1.png";
              break;
        }
        String [] [] inventario = worm.getInv();
        for(int i = 0; i < 50; i++){
            try {
                if (inventario[i][0].equals(mineriosS)) {
                    inventario[i][1] = (Integer.parseInt(inventario[i][1]) + 1) + "";
                    definido = true;
                    break;
                }
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        if(!definido){
            for(int i = 0; i < 50; i++){
                if(inventario[i][0] == null){
                    inventario[i][0] = mineriosS;
                    inventario[i][1] = "1";
                    inventario[i][2] = minerio+"";
                    break;
                }
            }
        }
        worm.setInv(inventario);
    }
 
    public String raridade(int r){
        String raridade;
        switch (r) {
            case 5:
                raridade = "sprites/inventario/SlotTerra_1.png";
                break;
            case 4:
                raridade = "sprites/inventario/SlotCobre_1.png";
                break;
            case 3:
                raridade = "sprites/inventario/SlotFerro_1.png";
                break;
            case 2:
                raridade = "sprites/inventario/SlotOuro_1.png";
                break;
            case 1:
                raridade = "sprites/inventario/SlotDiamante_1.png";
                break;
            case 0:
                raridade = "sprites/inventario/SlotRubi_1.png";
                break;
            default:
                raridade = "sprites/minerios/nada_1.png";
                break;
        }
    return raridade;
    }
}
