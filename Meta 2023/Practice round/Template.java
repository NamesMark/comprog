import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



/*
 * Only classes with 'Main' name are accepted in CodeChef and some other online judges
 */
public class Template {

	public static String output = "";

	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		final int cases;
		try {
			cases = Integer.parseInt(br.readLine().trim());

			Solver solver = new Solver();
			for (int i = 0; i < cases; i++) {				
				solver.solve(br.readLine());
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(output);
	}

}


class Solver {

    public void solve(String input) {					
        Template.output = Template.output.concat(input + "\n");	
    }

}