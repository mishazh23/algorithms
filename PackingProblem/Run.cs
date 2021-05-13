using System;

namespace PackingProblem
{
    class Run
    {
        static void Main(string[] args)
        {
            int n = 1000;
            double[] items = new double[n];
            Random random = new Random();

            for (int i = 0; i < n; i++)
            {
                items[i] = random.NextDouble();
            }

            Console.WriteLine("Next fit: " + Boxing.NextFit(items));
            Console.WriteLine("First fit: " + Boxing.FirstFit(items));
            Console.WriteLine("Best fit: " + Boxing.BestFit(items));
            Console.WriteLine("First Fit Decreasing: " + Boxing.FirstFitDecreasing(items));
        }
    }
}
