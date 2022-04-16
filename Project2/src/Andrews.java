
public class Andrews {
    private String name;
    private int hole;
    private int yards;
    private int par;
     
    public Andrews(String name, int hole, int yards, int par) {
    	 this.name = name;
    	 this.hole = hole;
    	 this.yards = yards;
    	 this.par = par;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHole() {
		return hole;
	}

	public void setHole(int hole) {
		this.hole = hole;
	}

	public int getYards() {
		return yards;
	}

	public void setYards(int yards) {
		this.yards = yards;
	}

	public int getPar() {
		return par;
	}

	public void setPar(int par) {
		this.par = par;
	}
     
}
