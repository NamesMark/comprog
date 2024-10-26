use std::fs;
use std::cmp::max;

const PATH: &str = "input.txt";
const MAX_RED: u32 = 12;
const MAX_GREEN: u32 = 13;
const MAX_BLUE: u32 = 14;

fn main() {
    let mut contents = fs::read_to_string(PATH).expect("Couldn't read lol");

    let lines = contents.lines();

    let mut sum = 0;

    'outer:for line in lines {
        let comps: Vec<&str> = line.split(":").collect();

        let day_str: String = comps[0].chars().filter(|x| x.is_digit(10)).collect();
        let day: u32 = day_str.parse().unwrap();

        let mut red = 1;
        let mut blue = 1;
        let mut green = 1;

        println!("{day}");
        println!("{}", comps[1]);

        let attempt_comps: Vec<&str> = comps[1].split(";").collect();
        for a_c in attempt_comps {
            let cube_comps: Vec<&str> = a_c.split(", ").collect();
            for c_c in cube_comps {
                println!("{}", c_c);
                let cc_comps: Vec<&str> = c_c.trim().split(" ").collect();
                println!("{}", cc_comps[0]);
                println!("{}", cc_comps[1]);
                let num: u32 = cc_comps[0].trim().parse().unwrap();
                match cc_comps[1] {
                    // "red" => if num > MAX_RED { continue 'outer; },
                    // "blue" => if num > MAX_BLUE { continue 'outer;  },
                    // "green" => if num > MAX_GREEN { continue 'outer;  },
                    "red" => red = max(red, num),
                    "blue" => blue = max(blue, num),
                    "green" => green = max(green, num),
                    _ => panic!("Wtf is this color")
                }
            }
        }

        sum += red*blue*green;
 
        println!("{}", comps[1]);
        
    }

    println!("{}", sum);
}
    