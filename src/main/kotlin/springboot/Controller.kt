package springboot

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController
class GreetingController {

    val counter = AtomicLong()

    @GetMapping(value = ["/greeting"])
    fun greeting(@RequestParam(value = "name", defaultValue = "Anonymous") name: String) = mapOf(
            "name" to name,
            "visits" to counter.getAndIncrement(),
            "lang " to "kotlin",
            "info" to mapOf("version" to 1.2),
            "targets" to listOf("jvm", "js", "android", "native")
    )

    @Autowired
    lateinit var employeeService: EmployeeService

    @GetMapping(value = ["/fizzbuzz"])
    fun fizzBuzz(@RequestParam(value = "n") n: Int) = employeeService.fizzBuzz(n)
}
