use std::io::{self, BufRead};

fn solve(a: i32, b: i32) -> i32 {
    a + b
}

fn main() {
    let stdin = io::stdin();
    let mut stdin_iterator = stdin.lock().lines();
    
    //let t = stdin_iterator.next().unwrap().unwrap().trim().parse::<i32>().unwrap();

    // for _ in 0..t {
    //     let n = stdin_iterator.next().unwrap().unwrap().trim().parse::<i32>().unwrap();
    //     let result = solve(a, b)
    //     println!("{}", result);
    // }

    let line = stdin_iterator.next().unwrap().unwrap();
    let nums: Vec<i32> = line.trim().split_whitespace().map(|n| n.parse().unwrap()).collect();

    if nums.len() == 2 {
        let (a, b) = (nums[0], nums[1]);
        println!("{}", solve(a, b));
    } else {
        eprintln!("Expected two numbers");
    }
}
