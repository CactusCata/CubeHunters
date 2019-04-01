package ch.system;

import ch.items.enums.Material;

public class SubInformation {

	private int itemCreatedNumber;
	private final int numberCreated;
	private final Material forWhatItem;
	private int help;

	public SubInformation(Material forWhatItem, int numberCreated) {
		this.forWhatItem = forWhatItem;
		this.numberCreated = numberCreated;
		add();
	}

	public void add() {
		this.itemCreatedNumber++;
	}

	public String getText() {
		update();
		final StringBuilder build = new StringBuilder("x" + this.itemCreatedNumber + " {"
				+ this.forWhatItem.getRecuperationType() + "} \"" + this.forWhatItem.toString() + "\" ");
		if (help != 0)
			build.append(this.help != 1 ? "x" + ListItem.getMapItems().get(forWhatItem).getTotalAmount() : "");
		else
			build.append(
					ListItem.getMapItems().get(forWhatItem).getTotalAmount() != 1 ? "x" + ListItem.getMapItems().get(forWhatItem).getTotalAmount() : "");

		return build.toString();
	}

	private void update() {
		if (this.numberCreated != 1) {
			this.itemCreatedNumber /= numberCreated;
			this.help = this.itemCreatedNumber;
			this.itemCreatedNumber = ListItem.getMapItems().get(forWhatItem).getTotalAmount();
		}
	}

}
