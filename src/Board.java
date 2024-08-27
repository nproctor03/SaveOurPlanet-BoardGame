package saveOurPlanetDev;

public class Board {
	
	private Field FossilFuel1 = new FossilFuel();
	private Field FossilFuel2 = new FossilFuel();
	private Field FossilFuel3 = new FossilFuel();
	private Field RenewableEnergy1 = new RenewableEnergy();
	private Field RenewableEnergy2 = new RenewableEnergy();
	private Field RenewableEnergy3= new RenewableEnergy();
	private Field Technology1 = new Technology();
	private Field Technology2 = new Technology();
	private Field Community1 = new Community();
	private Field Community2 = new Community();
	private Field start = new Start(); 
	private Field EcoBase2 = new EcoBase(); 
	
	// square vars declared and initialised with respective details and values
	private Square square1 = new Square("ECO Base", start, null, false);
	private Square square2 = new Square("Charity", Community1, null, false);
	private Square square3 = new Square("Recycling Centre", Community2, null, false);
	private Square square4 = new Square("Electric Cars", Technology1, null, false);
	private Square square5 = new Square("Carbon Capture", Technology2, null, false);
	private Square square6 = new Square("Coal", FossilFuel1, null, false);
	private Square square7 = new Square("Gas",  FossilFuel2, null, false);
	private Square square8 = new Square("Oil",  FossilFuel3, null, false);
	private Square square9 = new Square("Nuclear", RenewableEnergy1, null, false);
	private Square square10 = new Square("Hydroelectric", RenewableEnergy2, null, false);
	private Square square11 = new Square("Wind Energy", RenewableEnergy3, null, false);
	private Square square12 = new Square("Rest", EcoBase2, null, false);


	private Square[] board = { square1, square2, square3, square4, square5, square6, square7, square8, square9,
			square10, square11, square12 };

	
	// default constructor
	public Board() {}

	
	// get board method
	public Square[] getBoard() {
		return board;

	}

} // end of class