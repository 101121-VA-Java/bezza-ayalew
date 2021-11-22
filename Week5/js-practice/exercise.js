// Problem 1: Create a function "isWeekday" which takes a single argument and returns true if the argument is a day during the work week. It should return false if it is not.

function isWeekday(input) {
if(input == 'Saturday' || input == 'Sunday'){
    return false;
}
    return true;
}
// Problem 2: Create a function "isEven" which takes a single argument and returns true if the argument is an even integer. It should return false if it is not

function isEven(input) {
    result = false;
    if(input%2 ==0){
        result = true;   
    }
    return result;
}

// Problem 3: Write a JavaScript function which takes a single argument and returns the type

function findType(input) {
    return typeof(input);
}

// Problem 4: Write a JavaScript function which takes a single argument and determines if it's prime. If it is, return true. If it's not return false.

function isPrime(input) {
    
    if(input < 4){
        return true;
    } else{
        res = false;
        for(let i = 2; i <= Math.sqrt(input); i++){
            if(input%i==0){
                break;
            }
            res = true;
        }
    }
    return res;
}

// Problem 5: Write a JavaScript function which calculates the first number to the power of the second number. Do not do this recursively. Do not use the Math library.

function calculateExponent(base, exponent) {
    return base**exponent;
}
