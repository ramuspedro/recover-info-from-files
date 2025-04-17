package org.project

import java.io.File
import java.nio.file.Files
import java.nio.file.Paths
import java.util.stream.Collectors
import kotlin.io.path.name
import kotlin.io.path.pathString

fun main() {
    val extension = "kt"
    val inputDirPath = "src/file/name"
    val outputFilePath = "result.md" // will be generated on the root f this project
    File(outputFilePath).bufferedWriter().use { outResult ->
        Files
            .walk(Paths.get(inputDirPath))
            .collect(Collectors.toList())
            .filter { filePath -> filePath.name.takeLast(extension.length) == extension }
            .forEach { filePath ->
                outResult.write(filePath.pathString)
                outResult.newLine()
                outResult.write("```$extension")
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
