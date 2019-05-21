package main.java;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;

import main.java.bci.DefaultClassAdapter;

public class Transformer implements ClassFileTransformer {
	public byte[] transform(ClassLoader classLoader, String className, Class<?> arg2, ProtectionDomain domain,
			byte[] byteCodebuffer) throws IllegalClassFormatException {

		byte[] originByteCode = byteCodebuffer;

		ClassReader cr = new ClassReader(byteCodebuffer);
		ClassWriter cw = new ClassWriter(cr, ClassWriter.COMPUTE_FRAMES);
		ClassVisitor cv = new DefaultClassAdapter(Opcodes.ASM5);

		byte[] transformByteCode = cw.toByteArray();
		
		return transformByteCode;
	}
}
