package com.dev.akka.simple;

import akka.actor.UntypedActor;

public class Listener extends UntypedActor {
    public void onReceive(Object message) {
      if (message instanceof PiApproximation) {
        PiApproximation approximation = (PiApproximation) message;
        System.out.println(String.format("Final Result: \nPi approximation: %s\nCalculation time: %s",
            approximation.getPi(), approximation.getDuration()));
        getContext().system().shutdown();
      } else {
        unhandled(message);
      }
    }
  }