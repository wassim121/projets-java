package corba;

import CalculModule.CalculPOA;

public class CalculImpl extends CalculPOA {
	@Override
    public double addition(double a, double b) {
        return a + b;
    }

    @Override
    public double multiplication(double a, double b) {
        return a * b;
    }

    @Override
    public double soustraction(double a, double b) {
        return a - b;
    }

	@Override
	public double division(double a, double b) {
		// TODO Auto-generated method stub
		return 0;
	}

	

	


	
}
