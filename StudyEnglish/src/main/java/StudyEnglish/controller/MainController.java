package StudyEnglish.controller;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.security.acl.Group;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.node.ObjectNode;

import StudyEnglish.model.Audio;
import StudyEnglish.model.Contentstory;
import StudyEnglish.model.Mytopic;
import StudyEnglish.model.Myvocabulary;
import StudyEnglish.model.Part1;
import StudyEnglish.model.Proccess;
import StudyEnglish.model.TalkResource;
import StudyEnglish.model.Typeword;
import StudyEnglish.model.Unit;
import StudyEnglish.model.Users;
import StudyEnglish.model.Vocabulary;
import StudyEnglish.service.ServiceAll;

@Controller
public class MainController {
	@Autowired
	private ServiceAll sv;

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/JSONTypeword")
	@ResponseBody
	public List<Typeword> JSONTypeword() {
		List<Typeword> list = new ArrayList<Typeword>();
		list = sv.findAllTypeWord();
		return list;
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/JSONUnit")
	@ResponseBody
	public List<Unit> JSONUnit() {
		List<Unit> list = new ArrayList<Unit>();
		list = sv.findAllUnit();
		return list;
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/JSONUsers")
	@ResponseBody
	public List<Users> JSONUsers() {
		List<Users> list = new ArrayList<Users>();
		list = sv.findAllUsers();
		return list;
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/JSONVocabulary") // Load vocabulary part 2
	@ResponseBody
	public List<Vocabulary> JSONVocabulary() {
		List<Vocabulary> list = new ArrayList<Vocabulary>();
		List<Vocabulary> listVocaPart2 = new ArrayList<Vocabulary>();
		list = sv.findAllVocabulary();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getIdpart1() == 2) {
				listVocaPart2.add(list.get(i));
			}
		}
		Collections.sort(listVocaPart2, new Vocabulary());
		return listVocaPart2;
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/JSONAudio")
	@ResponseBody
	public List<Audio> JSONAudio() {
		List<Audio> list = new ArrayList<Audio>();
		list = sv.findAllAudio();
		return list;
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/JSONContentstory")
	@ResponseBody
	public List<Contentstory> JSONContentstory() {
		List<Contentstory> list = new ArrayList<Contentstory>();
		list = sv.findAllContentstory();
		return list;
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/JSONMytopic")
	@ResponseBody
	public List<Mytopic> JSONMytopic() {
		List<Mytopic> list = new ArrayList<Mytopic>();
		list = sv.findAllMytopic();
		return list;
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/JSONMyvocabulary")
	@ResponseBody
	public List<Myvocabulary> JSONMyvocabulary() {
		List<Myvocabulary> list = new ArrayList<Myvocabulary>();
		list = sv.findAllMyvocabulary();
		return list;
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/JSONPart1")
	@ResponseBody
	public List<Part1> JSONPart1() {
		List<Part1> list = new ArrayList<Part1>();
		list = sv.findAllPart1();
		return list;
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/JSONContentstoryTextbox")
	@ResponseBody
	public List<Contentstory> TraVe3ChamTrongContent(HttpServletRequest request) {
		List<Contentstory> list = new ArrayList<Contentstory>();
		List<Vocabulary> listVoca = JSONVocabulary();

		listVoca = sv.findAllVocabulary();
		list = sv.findAllContentstory();
		String l = "";
		String temp = "";
		int key = 1;

		for (int i = 0; i < list.size(); i++) {

			for (int j = 0; j < listVoca.size(); j++) {
				if (!(list.get(i).getContentenglish().indexOf(listVoca.get(j).getVoca()) == -1)) {
					temp = "<input id='" + (1001 + key++) + "'" + " class='input-part1' "
							+ "   maxLength='14'></input>";
					l = list.get(i).getContentenglish().replace(listVoca.get(j).getVoca(), temp);
					list.get(i).setContentenglish(l);
					// TODO:
					// replace("<span style='color: #ff0000;'>" + listVoca.get(j).getVoca() +
					// "</span>", temp);
					// Đổi lại style='color: #ff0000;' thành class='voca-part1'

				}
			}

		}
		return list;
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/SaveMyTopic")
	@ResponseBody
	public void saveMyTopic(@Valid @RequestBody Mytopic MyTopicObj) {
		sv.saveMyTopic(MyTopicObj);
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/DeleteMyTopic")
	@ResponseBody
	public void deleteMyTopic(@RequestBody JSONObject idTopic) {
		JSONObject json = new JSONObject(idTopic);
		int id = Integer.parseInt(json.get("idmytopic").toString());
		sv.DeleteMyTopic(id);
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@ResponseBody
	@PostMapping("/DeleteMyVocabulary")
	public void deleteMyVocabulary(@RequestBody JSONObject idVoca) {
		JSONObject json = new JSONObject(idVoca);
		int id = Integer.parseInt(json.get("idmyvocabulary").toString());
		sv.deleteMyVocabulary(id);
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/SaveMyVocabulary")
	@ResponseBody
	public void saveMyVOcabulary(@Valid @RequestBody Myvocabulary MyVocaObj) {
		sv.saveMyVocabulary(MyVocaObj);
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/CheckProcess") // Lưu quá trình học khi user học thêm part or unit mới
	@ResponseBody
	public void checkProcess(@RequestBody JSONObject checkProcess) {
		// @RequestParam String unit,@RequestParam String part,@RequestParam int user
		JSONObject json = new JSONObject(checkProcess);
		String unit = json.get("unit").toString();
		String part = json.get("part").toString();
		int user = Integer.parseInt(json.get("iduser").toString());
		Proccess pc = new Proccess();

		List<Proccess> list1 = new ArrayList<Proccess>();
		list1 = sv.findAllProccess();
		List<Proccess> list = new ArrayList<Proccess>();
		for (int i = 0; i < list1.size(); i++) {
			if (user == list1.get(i).getIduser()) {
				list.add(list1.get(i));
			}
		}
		if (list.size() > 0) {
			if (Integer.parseInt(part) > Integer.parseInt(list.get(list.size() - 1).getPart())) {
				if (Integer.parseInt(unit) >= Integer.parseInt(list.get(list.size() - 1).getUnit())) {

					pc.setIduser(user);
					pc.setPart(part);
					pc.setUnit(unit);
					sv.saveProcess(pc);
				}
			}
		}

		else {
			pc.setIduser(user);
			pc.setPart("1");
			pc.setUnit("1");
			sv.saveProcess(pc);
			if (Integer.parseInt(part) > Integer.parseInt(list.get(list.size() - 1).getPart())) {
				if (Integer.parseInt(unit) >= Integer.parseInt(list.get(list.size() - 1).getUnit())) {

					pc.setIduser(user);
					pc.setPart(part);
					pc.setUnit(unit);
					sv.saveProcess(pc);
				}
			}
		}

	}

	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/GetProcess") // Lấy quá trình học mới nhất của user
	@ResponseBody
	public List<Proccess> getProcess() {
		List<Proccess> list1 = new ArrayList<Proccess>();
		list1 = sv.findAllProccess();
		List<Proccess> list = new ArrayList<Proccess>();
		list.add(list1.get(list1.size() - 1));
		return list1;
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/paging") // phan trang
	@ResponseBody
	public List<Vocabulary> nextpage(@RequestBody JSONObject page) {
		JSONObject json = new JSONObject(page);
		int idpage = Integer.parseInt(json.get("idpage").toString());
		int countVoca = 6;
		int vt = idpage - 1;
		vt = vt * countVoca;
		List<Vocabulary> list = sv.findAllVocabulary();
		List<Vocabulary> listDisplay = new ArrayList<Vocabulary>();
		for (int i = vt; i < vt + countVoca; i++) {
			listDisplay.add(list.get(i));
		}
		return listDisplay;
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/Audio")
	@ResponseBody
	public TalkResource JSON(@RequestBody JSONObject jsonAudio) {
		JSONObject json = new JSONObject(jsonAudio);
		String audio = json.get("voca").toString();
		return new TalkResource(audio);
	}
}