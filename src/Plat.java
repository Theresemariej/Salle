
public class Plat {
	private Long id;
	private String description;
	private int qtt;
	
	public Plat(Long id2, String desc) {
		this.id = id2;
		this.description = desc;
		this.qtt = 0;//au début, qtt=0
	
	}
	
	public Long getId() {
		return id;
	}
	
	public String getDescription() {
		return description;//C'est le nom en fait
	}

	/**
	 * @return the qtt
	 */
	public int getQtt() {
		return qtt;
	}

	/**
	 * @param qtt the qtt to set
	 */
	public void setQtt(int qtt) {
		this.qtt = qtt;
	}
	

}
