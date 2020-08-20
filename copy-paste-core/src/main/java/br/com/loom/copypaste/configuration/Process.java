package br.com.loom.copypaste.configuration;

import br.com.loom.copypaste.step.Step;
import lombok.Data;

import java.util.List;

@Data
public class Process {

    String name;
    List<Step> steps;

}
