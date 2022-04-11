import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.codehaus.groovy.ast.ASTNode;
import org.codehaus.groovy.ast.builder.AstBuilder;
import org.codehaus.groovy.control.CompilePhase;

public class HelloWorld
{
    public static void main(String[] args) throws IOException {
        System.out.println("Hello World");

        Path fileName = Path.of("build.gradle");
        String buildGradle = Files.readString(fileName);
        //System.out.println(buildGradle);

        AstBuilder astBuilder = new AstBuilder();
        List<ASTNode> astNodes = astBuilder.buildFromString(CompilePhase.CONVERSION, buildGradle);
        System.out.println(astNodes);
    }
}

