package ex1_java;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class ColoredCols {
	private double cols;

	public ColoredCols(int num_of_cols) {
		if(num_of_cols < 1 || num_of_cols > 50) {
			System.err.print("Invalid Number Of Columns, value set to 10 by default");
			cols = 10; //default value
		}
		cols = num_of_cols;
	}

	public String get_color_by_iteration(int i) {
		if(i%3 == 0) { return "#0000FF"; }
		else if(i%3 == 1) { return "#FF0000"; }
		return  "#008000";
	}

	public void iter_cols() {
		try {
			PrintWriter writer = new PrintWriter("q4.html", "UTF-8");
			writer.println("<html>\r\n" + "<head>\r\n" + "    <meta charset=\"utf-8\" />\r\n" + 
					"    <title></title>\r\n" + "</head>\r\n" + "<body>");
			double percentage = (1/cols) * 100;
			String slash = "\"";
			String color = "";
			for(int i = 0 ; i < cols ; i++) {
				color = get_color_by_iteration(i);
				writer.println("<div style=" + slash + "background-color: "
						+ color + "; width: " +	percentage + 
						"%; height: 1000px; float: left" + slash + "></div>");
			}
			writer.println("</body>\r\n" + "</html>");
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	public static void main(String [] args) {
		ColoredCols cc = new ColoredCols(25);
		cc.iter_cols();
	}
}