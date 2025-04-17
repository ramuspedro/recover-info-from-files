package org.project

import java.io.File
import java.nio.file.Files
import java.nio.file.Paths
import java.util.stream.Collectors
import kotlin.io.path.name
import kotlin.io.path.pathString

fun main() {
    val typeOfFile = "kt"
    val mainPath = "C:\\Users\\hilana.pereira\\Pedro\\Projetos\\codecrafters\\codecrafters-redis-kotlin"
    val resultFileName = "result.md" // will be generated on the root f this project
    File(resultFileName).bufferedWriter().use { outResult ->
        Files
            .walk(Paths.get(mainPath))
            .collect(Collectors.toList())
            .forEach { filePath ->
                if (filePath.name.takeLast(typeOfFile.length) == typeOfFile) {
                    outResult.write(filePath.pathString)
                    outResult.newLine()
                    outResult.write("```$typeOfFile")
                    outResult.newLine()
                    File(filePath.pathString).forEachLine { outKt ->
                        outResult.write(outKt)
                        outResult.newLine()
                    }
                    outResult.write("```")
                    outResult.newLine()
                }
            }
    }
}
