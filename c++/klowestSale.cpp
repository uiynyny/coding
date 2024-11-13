// c++.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
#include <queue>


int klowestSale(const std::vector<int> sales, int k) {
	if (sales.empty()) return -1;
	std::priority_queue<int, std::vector<int>, std::less<int>> heap_order;
	for (int s : sales) {
		if (s > sales.size() - 1) {
			heap_order.push(s);
		}
	}
	if (heap_order.empty()|| heap_order.size()<k) return -1;
	while (!heap_order.size() > k && k > 1) {
		heap_order.pop();
		k--;
	}
	return heap_order.top();
}

int main()
{
	std::vector<int> sales = { 0,1,2,3,6,7 };
	auto t = klowestSale(sales,1);
	std::cout << t << std::endl;

}

// Run program: Ctrl + F5 or Debug > Start Without Debugging menu
// Debug program: F5 or Debug > Start Debugging menu

// Tips for Getting Started: 
//   1. Use the Solution Explorer window to add/manage files
//   2. Use the Team Explorer window to connect to source control
//   3. Use the Output window to see build output and other messages
//   4. Use the Error List window to view errors
//   5. Go to Project > Add New Item to create new code files, or Project > Add Existing Item to add existing code files to the project
//   6. In the future, to open this project again, go to File > Open > Project and select the .sln file
