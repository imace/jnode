/*
 * $Id$
 */
package org.jnode.vm.x86;

import org.jnode.vm.VmArchitecture;
import org.jnode.vm.VmStackReader;
import org.jnode.vm.compiler.NativeCodeCompiler;
import org.jnode.vm.x86.compiler.l0.X86Level0Compiler;
import org.jnode.vm.x86.compiler.l1.X86Level1Compiler;

/**
 * Architecture descriptor for the Intel X86 architecture.
 * 
 * @author Ewout Prangsma (epr@users.sourceforge.net)
 */
public final class VmX86Architecture extends VmArchitecture {

	final static VmX86Architecture INSTANCE = new VmX86Architecture();
	public static final int SLOT_SIZE = 4;
	
	/** The stackreader of this architecture */
	private final VmX86StackReader stackReader = new VmX86StackReader();
	
	/** The compilers */
	private final NativeCodeCompiler[] compilers = { new X86Level0Compiler(), new X86Level1Compiler() };
	
	/**
	 * Gets the name of this architecture.
	 * @return name
	 */
	public final String getName() {
		return "x86";
	}
	
	/**
	 * Gets the size in bytes of an object reference.
	 * @return Size of reference, always 4 here
	 */
	public final int getReferenceSize() {
		return SLOT_SIZE;
	}

	/**
	 * Gets the stackreader for this architecture.
	 * @return Stack reader
	 */
	public final VmStackReader getStackReader() {
		return stackReader;
	}

	/**
	 * Gets all compilers for this architecture.
	 * 
	 * @return The compilers, sorted by optimization level, from least optimizations to most
	 *         optimizations.
	 */
	public final NativeCodeCompiler[] getCompilers() {
		return compilers;
	}
}
