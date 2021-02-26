using System;

namespace TuringMachine
{
    class Run
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Enter string that starts and ends with '#' and includes only 'a', 'b', 'c': ");
            string tape1 = Console.ReadLine();
            TuringMachine machine = new TuringMachine();
            machine.Task1();
            char[] result1 = TuringMachine.TuringMachineProccesing(tape1.ToCharArray());
            Console.WriteLine(result1);

            Console.WriteLine("Enter string that starts and ends with '##' and includes only '1': ");
            string tape2 = Console.ReadLine();
            machine.Task2();
            char[] result2 = TuringMachine.TuringMachineProccesing(tape2.ToCharArray()); 
            Console.WriteLine(result2);
        }
    }
}
