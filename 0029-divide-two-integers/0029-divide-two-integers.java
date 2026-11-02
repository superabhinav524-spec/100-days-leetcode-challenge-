class Solution {
    public int divide(int dividend, int divisor) {
        // Handle the single overflow case: -2^31 / -1 = 2^31 (which overflows to 2^31 - 1)
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Determine the sign of the result
        // True if both have the same sign, False if signs are different
        boolean isPositive = (dividend > 0 == divisor > 0);

        // Convert both numbers to negative to prevent overflow issues
        // (The negative range in 32-bit integers is larger than the positive range)
        int a = dividend > 0 ? -dividend : dividend;
        int b = divisor > 0 ? -divisor : divisor;

        int quotient = 0;

        // Perform exponential search / bit-shifting division
        while (a <= b) {
            int tempDivisor = b;
            int multiple = 1;

            // Shift the divisor left (double it) as long as it doesn't underflow
            // and remains greater than or equal to the dividend 'a'
            while (tempDivisor >= Integer.MIN_VALUE >> 1 && a <= (tempDivisor << 1)) {
                tempDivisor <<= 1;
                multiple <<= 1;
            }

            // Subtract the accumulated divisor from the dividend
            a -= tempDivisor;
            // Add the multiple to the quotient
            quotient += multiple;
        }

        // Apply the correct sign to the result
        return isPositive ? quotient : -quotient;
    }
}
