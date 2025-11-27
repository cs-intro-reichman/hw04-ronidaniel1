public class Primes {
    public static void main(String[] args) {
        // Parse the input number n from the command line arguments
        final int n = Integer.parseInt(args[0]);
        
        // Create a boolean array to mark prime numbers.
        // Size is n + 1 because we want to include the index 'n'.
        boolean[] isPrime = new boolean[n + 1];
        
        // Initialize the array: assume all numbers from 2 to n are prime initially.
        // (Default boolean value is false, so we set them to true).
        int i = 2;
        while (i <= n) {
            isPrime[i] = true;
            i++;
        }
        
        // The Sieve of Eratosthenes algorithm
        // We only need to check divisors up to the square root of n.
        int p = 2;
        while (p * p <= n) {
            // If p is prime, mark all its multiples as not prime
            if (isPrime[p]) {
                int multiple = p * p; // Start marking from p^2
                while (multiple <= n) {
                    isPrime[multiple] = false;
                    multiple = multiple + p;
                }
            }
            p++;
        }
        
        // Print the results
        System.out.println("Prime numbers up to " + n + ":");
        
        int count = 0;
        int printIndex = 2;
        while (printIndex <= n) {
            if (isPrime[printIndex]) {
                System.out.println(printIndex);
                count++;
            }
            printIndex++;
        }
        
        // Calculate and print the summary statistics
        // Note: casting to integer effectively rounds down/truncates, matching the example (33% for 10/30)
        int percentage = (int) (((double) count / n) * 100);
        System.out.println("There are " + count + " primes between 2 and " + n + " (" + percentage + "% are primes)");
    }
}