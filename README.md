# onlinesales.ai-assignment
Task-1
Simulation of an Event that Follows Given Biasness

Problem Statement: Write a program that accepts a map of all possible outcomes of an event along with their probabilities and every occurrence of the event would generate outcomes based on the given probabilities. This could be seen as a generalization of events like rolling of a dice (could be biased) or flipping of a coin (could be biased). 
Examples
Rolling of a six-faced biased dice
Input: [ {1, 10}, {2, 30}, {3, 15}, {4, 15}, {5, 30}, {6, 0} ]
Flipping of a coin
Input [ {“Head”: 35}, {“Tail”: 65} ]
Rules
Input: Probabilities given are as integers and percentages.
Each occurrence of the event should only generate one of the outcomes given in input
The outcome of each occurrence is independent of that of others.
On observing a large number (say 1000) of occurrences, the probability distribution should roughly follow the given biasness.
Example
Input: [ {1: 35}, {2: 65} ]  ## 1=Head, 2=Tail
Output:
On triggering the event 1000 times, Head appeared 332 times and Tail 668 times which is roughly inline with the biasness given.
This is just one of the possibilities.






Task-2
Evaluate multiple mathematical expressions at once using a Web API

Problem Statement
Write a program that accepts multiple mathematical expressions in bulk and evaluates each of them using any public Web API available. The program should display the result of each expression on the console. Let’s assume that the API only supports 50 requests per second per client whereas your application is expected to evaluate at least 500 expressions per second. Also, the user may initiate more concurrent requests than your application can handle. Suggest an approach to handle this along with the reasoning and implementation of the same.

Rules
No expressions should be evaluated in the code. All evaluations should be using the Web API.
You can assume different expressions/operators that are compatible with the API you choose. 
Example: Some API might use ^ operator for power some might use pow()
Example
Input (every line is an expression, evaluate when “end” is provided as an expression)
2 * 4 * 4
5 / (7 - 5)
sqrt(5^2 - 4^2)
sqrt(-3^2 - 4^2)
end
Output
2 * 4 * 4 => 32
5 / (7 - 5) => 2.5
sqrt(5^2 - 4^2) => 3
sqrt(-3^2 - 4^2) = 5i



Task-3 Debugging
Given below is a Bash / Python script that performs following computation on an integer input (n):
If n is less than 10: Calculate its Square
Example: 4 => 16
If n is between 10 and 20: Calculate the factorial of (n-10)
Example: 15 => 120
If n is greater than 20: Calculate the sum of all integers between 1 and (n-20)
Example: 25 => 15
