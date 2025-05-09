package functions;

public class WorldGeneration {

    public int transform(String seedS) {
        int seed = 0;
        while (seedS.length() < 40) {
            seedS += seedS;
        }
        boolean worked = true;
        while (worked) {
            try {
                seed = Integer.parseInt(seedS);
                worked = false;
            } catch (Exception e) {
                String seedA[] = seedS.split("");
                seedS = "";
                for (String c : seedA) {
                    if (Character.isDigit(c.charAt(0))) {
                        seedS += c;
                    } else {
                        switch (c) {
                            case "a":
                                seedS += "1";
                                break;
                            case "b":
                                seedS += "2";
                                break;
                            case "c":
                                seedS += "3";
                                break;
                            case "d":
                                seedS += "4";
                                break;
                            case "e":
                                seedS += "5";
                                break;
                            case "f":
                                seedS += "6";
                                break;
                            case "g":
                                seedS += "7";
                                break;
                            case "h":
                                seedS += "8";
                                break;
                            case "i":
                                seedS += "9";
                                break;
                            case "j":
                                seedS += "10";
                                break;
                            case "k":
                                seedS += "11";
                                break;
                            case "l":
                                seedS += "12";
                                break;
                            case "m":
                                seedS += "13";
                                break;
                            case "n":
                                seedS += "14";
                                break;
                            case "o":
                                seedS += "15";
                                break;
                            case "p":
                                seedS += "16";
                                break;
                            case "q":
                                seedS += "17";
                                break;
                            case "r":
                                seedS += "18";
                                break;
                            case "s":
                                seedS += "19";
                                break;
                            case "t":
                                seedS += "20";
                                break;
                            case "u":
                                seedS += "21";
                                break;
                            case "v":
                                seedS += "22";
                                break;
                            case "w":
                                seedS += "23";
                                break;
                            case "x":
                                seedS += "24";
                                break;
                            case "y":
                                seedS += "25";
                                break;
                            case "z":
                                seedS += "26";
                                break;
                            default:
                                seedS += "0";
                                break;
                        }
                    }
                }
                try {
                    seed = Integer.parseInt(seedS);
                    worked = false;
                } catch (Exception e2) {
                    String[] seedSA = seedS.split("");
                    for (String n : seedSA) {
                        seed += Integer.parseInt(n);
                    }
                    worked = false;
                }
            }
        }
        return seed;
    }

    public int[] gen(String seed) {
        int seedI = transform(seed);
        if(seedI<0){
            seedI = seedI*seedI;
        }
        int[] world = new int[340];
        int unluck = 0;
        for (int i = 0; i < world.length; i++) {
            world[i] = (((seedI + 1) * (i + 1) * 10) * ((seedI + 1) * ((i + 1) * 1965))) / 2025;
            int test = world[i] % 2701;
            if (test == 0) {
                world[i] = 0;// ruby
                unluck = 0;
            } else if (test > 0 && test <= 20) {
                world[i] = 1;// diamond
            } else if (test > 20 && test <= 100) {
                world[i] = 2;// gold
            } else if (test > 100 && test <= 500) {
                world[i] = 3;// iron
            } else if (test > 500 && test <= 1000) {
                world[i] = 4;// copper
            } else {
                world[i] = 5;// dirt
                unluck++;
                if (unluck == 200) {
                    unluck = 0;
                    world[i] = 0;
                }
            }
        }
        for (int i = 0; i < world.length; i++) {
            try {
                if (world[i - 1] == world[i + 1] && world[i] != 0 && world[i] < 5) {
                    world[i] += 1;
                }
                if (world[i - 26] == world[i + 26] && world[i] != 0) {
                    world[i] -= 1;
                }
            } catch (Exception e) {
                
            }
        }
        return world;
    }
}
