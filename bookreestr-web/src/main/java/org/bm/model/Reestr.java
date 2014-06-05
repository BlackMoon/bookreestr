/**
 * 
 */
package org.bm.model;

/**
 * @author Black Moon
 *
 */
public class Reestr implements Key{
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see org.bm.model.Key#getId()
	 */
	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}
}
