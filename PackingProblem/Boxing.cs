using System;
using System.Collections.Generic;
using System.Text;

namespace PackingProblem
{
    public class Boxing
    {
        private static double capacity = 1;

        public static int NextFit(double[] items)
        {
            int result = 0;
            double remainingSpace = capacity;

                for (int i = 0; i < items.Length; i++)
                {
                    if (items[i] > remainingSpace)
                    {
                    result++; 
                    remainingSpace = capacity - items[i];
                    }
                    else
                    remainingSpace -= items[i];
                }
            return result;
        }

        public static int FirstFit(double[] items)
        {
            int result = 0;
            double[] binRemainingSpace = new double[items.Length];
            for (int i = 0; i < items.Length; i++)
            {
                int j;
                for (j = 0; j < result; j++)
                {
                    if (binRemainingSpace[j] >= items[i])
                    {
                        binRemainingSpace[j] -= items[i];
                        break;
                    }
                }

                if (j == result)
                {
                    binRemainingSpace[result] = capacity - items[i];
                    result++;
                }
            }
            return result;
        }

        public static int BestFit(double[] items)
        {
            int result = 0;
            double[] binRemainingSpace = new double[items.Length];

            for (int i = 0; i < items.Length; i++)
            {
                int j;
                double spaceForBestBin = capacity;
                int bestBin = 0;

                for (j = 0; j < result; j++)
                {
                    if (binRemainingSpace[j] >= items[i]
                        && binRemainingSpace[j] - items[i] < spaceForBestBin)
                    {
                        bestBin = j;
                        spaceForBestBin = binRemainingSpace[j] - items[i];
                    }
                }

                if (spaceForBestBin == capacity)
                {
                    binRemainingSpace[result] = capacity - items[i];
                    result++;
                }
                else
                    binRemainingSpace[bestBin] -= items[i];
            }
            return result;
        }

        public static int FirstFitDecreasing(double[] items)
        {
            Array.Sort(items);
            Array.Reverse(items);
            return FirstFit(items);
        }
    }
}
