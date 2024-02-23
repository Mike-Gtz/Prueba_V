package com.example.demo.controllers;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.demo.models.CiudadanosModel;
import com.example.demo.repository.CiudadanoRepository;
import com.example.demo.models.DomiciliosModel;
import com.example.demo.repository.DomiciliosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.HttpURLConnection;
import java.util.*;

import java.util.List;

@Controller
public class controller {

    @GetMapping("/")
    public String Home() {
        return "index";
    }

    @Autowired
    CiudadanoRepository ciudadanoRepository;

    @Autowired
    DomiciliosRepository domiciliosRepository;

    @GetMapping("/ciudadanos")
    public String getCiudadanos(Model model){
        List<CiudadanosModel> list = ciudadanoRepository.findAll();
        model.addAttribute("datos", list);
        return "ciudadanos";
    }

    @GetMapping("/altaC")
    public String RegistroC(Model model) {
        model.addAttribute("ciudadano", new CiudadanosModel());
        return "altaCiudadano";
    }

    @PostMapping("/guardarC")
    public String guardar(CiudadanosModel ciudadano) {
        ciudadanoRepository.save(ciudadano);
        return "redirect:/ciudadanos";
    }

    @GetMapping("/borrar/{idciudadano}")
    public String borrar(CiudadanosModel ciudadano){
        ciudadanoRepository.deleteById(ciudadano.getIdciudadano());
        return "redirect:/ciudadanos";
    }

    @PostMapping("/editarC/{idciudadano}")
    public String updateEmployee(@PathVariable Long idciudadano, CiudadanosModel employeeDetails){
        CiudadanosModel employee = ciudadanoRepository.findById(idciudadano)
                .orElseThrow();

        employee.setNombre(employeeDetails.getNombre());
        employee.setApellidos(employeeDetails.getApellidos());
        employee.setEdad(employeeDetails.getEdad());

        CiudadanosModel updatedEmployee = ciudadanoRepository.save(employee);
        return "redirect:/ciudadanos";
    }

    @GetMapping("/prueba/{idciudadano}")
    public String getEmployeeById(@PathVariable Long idciudadano, Model model) {
        CiudadanosModel employee = ciudadanoRepository.findById(idciudadano)
                .orElseThrow();
        model.addAttribute("ciudadano", employee);
        return "modificarC";
    }




    @GetMapping("/domicilios")
    public String getDomicilios(Model model){
        List<DomiciliosModel> list = domiciliosRepository.findAll();
        model.addAttribute("datos", list);
        return "domicilios";
    }


    @GetMapping("/altaD")
    public String RegistroD(Model model) {
        List<CiudadanosModel> list = ciudadanoRepository.findAll();
        model.addAttribute("datos", list);
        model.addAttribute("domicilio", new DomiciliosModel());
        return "altaDomicilio";
    }

    @PostMapping("/guardarD")
    public String guardarD(DomiciliosModel domicilio) {
        domiciliosRepository.save(domicilio);

        return "redirect:/domicilios";
    }

    @GetMapping("/borrarD/{iddomicilio}")
    public String borrarD(DomiciliosModel domicilio){
        domiciliosRepository.deleteById(domicilio.getIddomicilio());
        return "redirect:/domicilios";
    }

    @PostMapping("/editarD/{iddomicilio}")
    public String updateEmployee(@PathVariable Long iddomicilio, DomiciliosModel domicilioDetails){
        DomiciliosModel domicilio = domiciliosRepository.findById(iddomicilio)
                .orElseThrow();

        domicilio.setCalle(domicilioDetails.getCalle());
        domicilio.setNumero(domicilioDetails.getNumero());
        domicilio.setColonia(domicilioDetails.getColonia());
        domicilio.setEstado(domicilioDetails.getEstado());
        domicilio.setMunicipio(domicilioDetails.getMunicipio());
        domicilio.setCiudadano(domicilioDetails.getCiudadano());

        DomiciliosModel updatedEmployee = domiciliosRepository.save(domicilio);
        return "redirect:/domicilios";
    }

    @GetMapping("/pruebaD/{iddomicilio}")
    public String getDomicilioById(@PathVariable Long iddomicilio, Model model) {
        DomiciliosModel domicilio = domiciliosRepository.findById(iddomicilio)
                .orElseThrow();
        model.addAttribute("domicilio", domicilio);
        return "modificarD";
    }

}
