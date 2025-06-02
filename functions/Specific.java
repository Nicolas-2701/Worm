package functions;

import java.util.Random;

import entidades.Worm;

public class Specific {

    public void armazenar(Worm worm, int minerio) {
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
        String[][] inventario = worm.getInventario().getInv();
        for (int i = 0; i < 50; i++) {
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
        if (!definido) {
            for (int i = 0; i < 50; i++) {
                if (inventario[i][0] == null) {
                    inventario[i][0] = mineriosS;
                    inventario[i][1] = "1";
                    inventario[i][2] = minerio + "";
                    break;
                }
            }
        }
        worm.getInventario().setInv(inventario);
    }

    public String raridade(int r) {
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

    public String[][] lojaItens(String[][] loja) {
        int[] numeros = { 0, 1, 2, 3, 4, 5 };
        int[] probabilidades = { 1, 5, 10, 15, 20, 49 };
        String[] itensTerra = { "Pena" };
        Random rand = new Random();
        int acumulado = 0;
        for (int i = 0; i < 3; i++) {
            int r = rand.nextInt(100) + 1; // 1 a 100
            for (int i2 = 0; i2 < numeros.length; i2++) {
                acumulado += probabilidades[i2];
                if (r <= acumulado) {
                    acumulado = numeros[i2];
                    break;
                }
            }
            switch (acumulado) {
                case 5:
                    loja[i][0] = "sprites/inventario/itens/" + itensTerra[rand.nextInt(itensTerra.length)] + "_1"
                            + ".png";
                    break;
                case 4:
                    loja[i][0] = "sprites/minerios/cobre_1.png";
                    break;
                case 3:
                    loja[i][0] = "sprites/minerios/ferro_1.png";
                    break;
                case 2:
                    loja[i][0] = "sprites/minerios/ouro_1.png";
                    break;
                case 1:
                    loja[i][0] = "sprites/minerios/diamante_1.png";
                    break;
                case 0:
                    loja[i][0] = "sprites/minerios/rubi_1.png";
                    break;
                default:
                    loja[i][0] = "sprites/minerios/nada_1.png";
                    break;
            }
            loja[i][1] = acumulado + "";
        }
        return loja;
    }

    public void comprar(Worm worm, String item, String raridade, ControlePersonagem controle) {
        String[][] inventario = worm.getInventario().getInv();
        boolean definido = false;
        int multi = 2;
        int necessarario = 0;

        switch (raridade) {
            case "5":
                necessarario = (1 * multi);
                break;
            case "4":
                necessarario = (4 * multi);
                break;
            case "3":
                necessarario = (8 * multi);
                break;
            case "2":
                necessarario = (16 * multi);
                break;
            case "1":
                necessarario = (320 * multi);
                break;
            case "0":
                necessarario = (640 * multi);
                break;
            default:
                break;
        }
        if (worm.getInventario().getDinheiro() >= necessarario) {
            worm.getInventario().setDinheiro(worm.getInventario().getDinheiro() - necessarario);
            for (int i = 0; i < 50; i++) {
                try {
                    if (inventario[i][0].equals(item)) {
                        inventario[i][1] = (Integer.parseInt(inventario[i][1]) + 1) + "";
                        definido = true;
                        break;
                    }
                } catch (Exception e) {
                    // TODO: handle exception
                }
            }
            if (!definido) {
                for (int i = 0; i < 50; i++) {
                    if (inventario[i][0] == null) {
                        inventario[i][0] = item;
                        inventario[i][1] = "1";
                        inventario[i][2] = raridade;
                        break;
                    }
                }
            }
        } else {
            controle.setComprado(false);
        }
    
    }
}
