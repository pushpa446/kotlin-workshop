package springboot

import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.junit.MockitoJUnitRunner

infix fun String.equals(that: String): Boolean = this == that

@RunWith(MockitoJUnitRunner::class)
class EmployeeServiceTests {

    @InjectMocks
    lateinit var employeeService: EmployeeService

    @Test
    fun shouldReturnTheSameNumberIfNumberIsNotMultipleOf3Or5() {
        assert(employeeService.fizzBuzz(1) equals 1.toString())
    }

    @Test
    fun shouldReturnFizzIfNumberIsDivisibleBy3() {
        assert(employeeService.fizzBuzz(3) equals "Fizz")
    }

    @Test
    fun shouldReturnBuzzIfNumberIsDivisibleBy5() {
        assert(employeeService.fizzBuzz(5) equals "Buzz")
    }

    @Test
    fun shouldReturnFizzBuzzIfNumberIsDivisibleBy15() {
        assert(employeeService.fizzBuzz(15) equals "FizzBuzz")
    }
}
