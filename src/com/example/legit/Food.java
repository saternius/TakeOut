package com.example.legit;
public class Food {
	public int carb; 
	public int fat; 
	public int prot;
	public int b6; 
	public int b12; 
	public int sod; 
	public int fib; 
	public int thia;
	public int nia; 
	public int vc; 
	public int calc;
	public int rib;
	public int iron;
	public int fol;
	public int mag;
	public int zinc;

	public Food(int carb, int fat, int prot, int b6, int b12, int sod, int fib, int thia, int nia, 
			int vc, int calc, int rib, int iron, int fol, int mag, int zinc){

		this.carb = carb+1;
		this.fat = fat+1;
		this.prot = prot+1;
		this.b6 = b6+1;
		this.b12 = b12+1;
		this.sod = sod+1;
		this.fib = fib+1;
		this.thia = thia+1;
		this.nia = nia+1; 
		this.vc = vc+1;
		this.calc = calc+1;
		this.rib = rib+1;
		this.iron = iron+1;
		this.fol = fol+1;
		this.mag = mag+1;
		this.zinc = zinc+1;
	}

	public double ratio(Food[] fs){
		int totalCal = 2000;
		int x = carb*4/1000 + fat*9/1000 + prot*4/1000;
		for(int i = 0; i<fs.length; i++){
			x+= fs[i].carb*4/1000 +fs[i].fat*9/1000 + fs[i].prot*4/1000; 
		}
		double foodRatio = totalCal/x;

		double[] minVitRats = new double[4];
		minVitRats[0] = (double) (20000/fib);
		minVitRats[0] = (double) (20000);
		minVitRats[1] = (double) (500/sod);
		minVitRats[2] = (double) (100/b6);
		minVitRats[3] = (double) (100/b12);
		minVitRats = sort(minVitRats);
		minVitRats[3] = (double) (100/thia);
		minVitRats = sort(minVitRats);
		minVitRats[3] = (double) (100/nia);
		minVitRats = sort(minVitRats);
		minVitRats[3] = (double) (100/vc);
		minVitRats = sort(minVitRats);
		minVitRats[3] = (double) (100/calc);
		minVitRats = sort(minVitRats);
		minVitRats[3] = (double) (100/rib);
		minVitRats = sort(minVitRats);
		minVitRats[3] = (double) (100/iron);
		minVitRats = sort(minVitRats);
		minVitRats[3] = (double) (100/fol);
		minVitRats = sort(minVitRats);
		minVitRats[3] = (double) (100/mag);
		minVitRats = sort(minVitRats);
		minVitRats[3] = (double) (100/zinc);
		minVitRats = sort(minVitRats);

		return Math.max(foodRatio, minVitRats[1]);

	}

	public static double[] sort(double[] x){
		for(int i = 0; i<x.length; i++){
			for(int j = i+1; j<x.length; j++){
				if(x[i] < x[j]){
					double temp = x[i];
					x[i] = x[j];
					x[j] = temp;
				}
			}
		}
		return x;
	}
}
