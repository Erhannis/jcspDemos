//////////////////////////////////////////////////////////////////////
//                                                                  //
//  jcspDemos Demonstrations of the JCSP ("CSP for Java") Library   //
//  Copyright (C) 1996-2018 Peter Welch, Paul Austin and Neil Brown //
//                2001-2004 Quickstone Technologies Limited         //
//                2005-2018 Kevin Chalmers                          //
//                                                                  //
//  You may use this work under the terms of either                 //
//  1. The Apache License, Version 2.0                              //
//  2. or (at your option), the GNU Lesser General Public License,  //
//       version 2.1 or greater.                                    //
//                                                                  //
//  Full licence texts are included in the LICENCE file with        //
//  this library.                                                   //
//                                                                  //
//  Author contacts: P.H.Welch@kent.ac.uk K.Chalmers@napier.ac.uk   //
//                                                                  //
//////////////////////////////////////////////////////////////////////

package jcspDemos.mandelbrot;



import jcsp.awt.*;

/**
 * @author P.H. Welch
 */
class FarmPacket implements Cloneable {

  public static final int STRIDE_SILENT = 5;

  public static final int SCROLL_SILENT = 0;
  public static final int SCROLL_UP = 1;
  public static final int SCROLL_DOWN = 2;
  public static final int NO_SCROLL = 3;

  public int maxIterations, scrolling, colourModel;

  public double left, top, size;

  public GraphicsCommand colouring;

  public boolean ok;

  public byte[] pixels;

  public void copy (final FarmPacket p) {
    maxIterations = p.maxIterations;
    scrolling = p.scrolling;
    colourModel = p.colourModel;
    left= p.left;
    top = p.top;
    size = p.size;
    colouring = p.colouring;
    ok = p.ok;
    System.arraycopy (p.pixels, 0, pixels, 0, pixels.length);
  }

  public Object clone () {
    try {
      final FarmPacket packet = (FarmPacket) super.clone ();
      packet.pixels = (byte[]) pixels.clone ();
      return packet;
    } catch (CloneNotSupportedException e) {
      System.out.println (e);
      System.exit (-1);
      return null;
    }
  }

}
