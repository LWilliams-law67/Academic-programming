
#include <iostream>
using namespace std;

int main(void)
{
    const double PI = 3.14159265359;
    double radius;
    double area;
    double circumference;

    cout << "Please input the radius: ";
    cin >> radius;

    area = PI * radius * radius;
    circumference = 2 * radius * PI;

    cout << "The area of a circle  is " << area << endl;
    cout << "The circumference of a circle is " << circumference << endl;
    return 0;
}
