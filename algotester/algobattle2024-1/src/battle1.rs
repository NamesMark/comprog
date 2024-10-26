use std::io::{self, BufRead};

fn solve(nums: Vec<i32>) -> i32 {
    nums.iter().sum::<i32>() - nums.iter().min().unwrap()
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

    if nums.len() == 4 {
        println!("{}", solve(nums));
    } else {
        eprintln!("Expected two numbers");
    }
}
