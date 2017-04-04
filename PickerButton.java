import javax.swing.JButton;

public class PickerButton extends JButton
{
	int piece;


	public PickerButton PickerButton(String color)
	{
		switch(color)
		{
			case("red"):
				this.setActionCommand("red");
				break;
			case("yellow"):
				this.setActionCommand("yellow");
				break;
			case("blue"):
				this.setActionCommand("blue");
				break;
			case("green"):
				this.setActionCommand("green");
				break;
		}

}
	}