using System.Collections.Generic;

namespace TuringMachine
{
    class TuringMachine
    {
        public static Dictionary<(string state, char symbol), (string new_state, char new_symbol, int step)> Transmissions;
        public  void Task1()
        {
            Transmissions = new Dictionary<(string state, char currentSymbol), (string nextState, char newSymbol, int shift)>
                    {
                        {("q0", '#'), ("q0", '#', 1)},
                        {("q0", 'a'), ("q1", 'a', 0)},
                        {("q0", 'b'), ("q1", 'b', 0)},
                        {("q0", 'c'), ("q1", 'c', 0)},

                        {("q1", 'a'), ("q2", 'a', 1)},
                        {("q1", 'b'), ("q1", 'c', 1)},
                        {("q1", 'c'), ("q1", 'c', 1)},
                        {("q1", '#'), ("qy", '#', 0)},

                        {("q2", 'a'), ("q2", 'a', 1)},
                        {("q2", 'b'), ("q2", 'b', 1)},
                        {("q2", 'c'), ("q2", 'c', 1)},
                        {("q2", '#'), ("q3", 'a', -1)},

                        {("q3", 'a'), ("q3", '#', -1)},
                        {("q3", 'b'), ("q3", '#', -1)},
                        {("q3", 'c'), ("q3", '#', -1)},
                        {("q3", '#'), ("qy", '#', 0)}
                    };
        }

        public void Task2()
        {
            Transmissions = new Dictionary<(string state, char currentSymbol), (string nextState, char newSymbol, int shift)>
                    {
                        {("q0", '#'), ("q0", '#', 1)},
                        {("q0", '1'), ("q1", '1', -1)},

                        {("q1", '#'), ("q2", '1', 1)},

                        {("q2", '1'), ("q2", '1', 1)},
                        {("q2", '#'), ("qy", '1', 0)}
                    };
        }

        public static char[] TuringMachineProccesing(char[] tape)
        {
            string state = "q0";
            int position = 0;

            while (state != "qy")
            {
                Transmissions.TryGetValue((state, tape[position]), out var value);
                state = value.new_state;
                tape[position] = value.new_symbol;
                position += value.step;
            }

            return tape;
        }

    }
}