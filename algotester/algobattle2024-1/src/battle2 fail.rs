use std::io::{self, BufRead};
use std::collections::HashSet;

fn solve(n: usize) -> Vec<usize> {
    let mut curr_array = vec![];
    let mut modulos = HashSet::new();
    let mut used = vec![false; n + 1];
    if backtrack(n, &mut used, &mut curr_array, &mut modulos, 0) {
        curr_array
    } else {
        panic!("Omg, couldn't find");
    }
}

fn backtrack(
    n: usize,
    used: &mut Vec<bool>,
    curr_array: &mut Vec<usize>,
    modulos: &mut HashSet<usize>,
    depth: usize,
) -> bool {
    if depth == n {
        return true;
    }

    for i in 1..=n {
        if !used[i] {
            let modulo = if curr_array.is_empty() {
                0
            } else {
                (curr_array.last().unwrap() + i) % n
            };

            if curr_array.is_empty() || !modulos.contains(&modulo) {
                used[i] = true;
                if !curr_array.is_empty() {
                    modulos.insert(modulo);
                }
                curr_array.push(i);

                if backtrack(n, used, curr_array, modulos, depth + 1) {
                    return true;
                }

                used[i] = false;
                curr_array.pop();
                if !curr_array.is_empty() {
                    modulos.remove(&modulo);
                }
            }
        }
    }

    false
}

fn check(nums: & Vec<usize>) -> bool {
    let set = nums.iter().zip(nums.iter().skip(1)).fold(std::collections::HashSet::new(), |mut acc, (n1, n2)| {
        acc.insert((n1+n2) % nums.len());
        acc
    });
    set.len() == nums.len()-1
}

fn main() {
    let stdin = io::stdin();
    let mut stdin_iterator = stdin.lock().lines();
    
    let n = stdin_iterator.next().unwrap().unwrap().parse::<usize>().unwrap();

    //let n = 15;
    //println!("\nN: {}", n);
    let result = solve(n);

    //println!("{}", check(&result));

    for num in result {
        print!("{} ", num);
    }
}
