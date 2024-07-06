public class QuestRewardGenerator {

    public static String generateRewards(int N) {
        StringBuilder rewards = new StringBuilder();
        
        for (int i = 0; i < N; i++) {
            double t = (double) i / (N - 1); // normalize i to range [0, 1]
            double probabilityOfSilver = interpolate(t);
            if (Math.random() < probabilityOfSilver) {
                rewards.append('s');
            } else {
                rewards.append('b');
            }
        }
        
        return rewards.toString();
    }
    
    private static double interpolate(double t) {
        // Custom interpolation function to mimic the given pattern
        if (t < 0.2) {
            return 0.1; // Low probability of 's' in the beginning
        } else if (t < 0.4) {
            return 0.3; // Gradually increase probability of 's'
        } else if (t < 0.6) {
            return 0.5; // Further increase probability of 's'
        } else if (t < 0.8) {
            return 0.7; // Even higher probability of 's'
        } else {
            return 0.9; // Very high probability of 's' towards the end
        }
    }

    public static void main(String[] args) {
        int N = 100; // Example value, change as needed
        String rewards = generateRewards(N);
        System.out.println(rewards);
    }
}
