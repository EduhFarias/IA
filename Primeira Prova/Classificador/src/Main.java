import java.util.*;

class Main {
	ArrayList<Double> attributes = new ArrayList<>();
	String type;
	ArrayList<Main> neighbors = new ArrayList<>();
	
	public Main(ArrayList<Double> attributes, String type, ArrayList<Main> neighbors){
		this.attributes = attributes;
		this.type = type;
		this.neighbors = neighbors;
	}

  	public static void main(String[] args) {
		ArrayList<Main> datas = new ArrayList<>();
		ArrayList<String> infos = new ArrayList<>();

		Util.accessUrl(infos);
		getValues(datas, infos);

		for(Main current : datas){
			System.out.printf("%.2f, %.2f, %.2f, %.2f -> %s\n", current.attributes.get(0), current.attributes.get(1), 
							current.attributes.get(2), current.attributes.get(3), current.type);
		}
  }

  	public static void getValues(ArrayList<Main> datas, ArrayList<String> infos){

    	for(String current : infos){
    		String aux = "";
        	ArrayList<Double> attributes = new ArrayList<>();
        	
			for(int i = 0; i < current.length(); i++){
            	if(current.charAt(i) == ','){
                	attributes.add(Double.parseDouble(aux));
                	aux = "";
            	} else aux += current.charAt(i);
        	}
			Main newData = new Main(attributes, aux, null);
			datas.add(newData);
    	}
    	datas.remove(150);
    }

	public static void distance(){
		//Criar um novo arraylist para poder armazenar os passos, o arraylist datas serve só como
		//um banco, aí começa a add um novo elemento retirado aleatoriamente do 'datas' e adicionando
		//nesse novo arraylist, já vai fazendo o calculo de distancia para achar as proximidades
		//talvez fazer o normalizador, mas ainda ver como fazer. 
	}
}
